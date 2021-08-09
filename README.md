### Problema

**Situação:** Temos uma método na classe A, dentro deste método é criado um objeto da classe B (de alguma biblioteca externa). Neste exemplo, o método da classe A precisa que um método de B realize alguma operação para finalmente poder ir adiante.

**Problema:** Sendo B criado dentro de A, e B.metodo necessário para o funcionamento de A.metodo. Como "mockar" o comportamento da classe B sem sair do escopo de teste da classe A?

**Código:**

	class ClasseA{
		void metodoDeA(){  
			ClasseB classeB = new ClasseB();  
			Object necessaryObject = classeB.metodoDeB();  
		}  
	}  
  
	class ClasseB{  
		Object metodoDeB() {  
			// consome API externa  
			return "Algum objeto necessário para A criado no código de B"; 
		}    
	}

### Solução

Uma alternativa de código para contornar o problema acima é utilizando o *design pattern Factory Methods*, no qual é criado uma interface para lidar apenas pela criação de um novo objeto, desacoplando esta responsabilidade de antiga criadora.

No exemplo anterior, é possível delegar o comportamento de criar um objeto dependente do método de B para uma classe FactoryB, então a class A se preocupará apenas com seu próprio objetivo e fluxo original de código (**S**OLID). Logo, durante o desenvolvimento dos testes, só o que importará para o teste do A.metodoDeA é se o retorno de FactoryB satisfaz suas necessidades.

	class ClasseA{  
		FactoryB factoryB;  
		
		public ClasseA(FactoryB factoryB){  
			this.factoryB = new FactoryBImpl();  
		}  
	
		void metodoDeA(){  
			// ... código ...  
			Object necessaryObject = factoryB.criaPorMeioDeB("algum parâmetro para B");  
			// ... faz algouma coisa ...  
		}  
	}
	
	interface FactoryB{
		Object criaPorMeioDeB(String algumParametroDeB);
	}

	class FactoryBImpl implements FactoryB{  
		Object criaPorMeioDeB(String algumParametroDeB) {  
			// ... código ..  
			ClasseB classeB = new ClasseB();  
			// ... faz a requisição ou seja lá o que for
			Object objectNecessarioEmA = classeB.metodoDeB();
			
			return objectNecessarioEmA;  
		}  
	}  

	class ClasseB{  
		// ... código ...  
		Object metodoDeB() {  
			// consome API externa  
			return "Algum objeto criado no código";  
		}  
	}