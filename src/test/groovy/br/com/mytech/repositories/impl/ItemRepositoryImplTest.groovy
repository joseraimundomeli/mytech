package br.com.mytech.repositories.impl

import br.com.mytech.models.ItemCustom
import br.com.mytech.repositories.ItemRepository
import spock.lang.Shared
import spock.lang.Specification

class ItemRepositoryImplTest extends Specification {
    @Shared
    private referenceItem1 = new ItemCustom("1", "Teste 1", 100.0, 10,"Eletro");
    @Shared
    private referenceItem2 = new ItemCustom("2", "Teste 2", 100.0, 10, "Eletro");

    @Shared
    private List<ItemCustom> referenceItemList;

    def setup(){
        referenceItemList =   [ referenceItem1, referenceItem2]
    }

    def "should return all itens in the dataset"() {

        given:
            ItemRepository itemRepository = new ItemRepositoryImpl(referenceItemList)
        when:
            def result = itemRepository.findAll()
        then:
            result == referenceItemList
    }

    def "should return return a item by id"() {
        given:
            ItemRepository itemRepository = new ItemRepositoryImpl(referenceItemList)
        when:
            def result = itemRepository.findById("1").get()
        then:
            result == referenceItem1
    }
}
