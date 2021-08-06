package br.com.mytech

import br.com.mytech.models.ItemGeneric
import br.com.mytech.repositories.ItemRepository
import br.com.mytech.repositories.impl.ItemRepositoryImpl
import br.com.mytech.services.PreferenceService
import br.com.mytech.services.impl.PreferenceServiceImpl
import com.mercadopago.exceptions.MPException
import com.mercadopago.resources.Preference
import com.mercadopago.resources.datastructures.preference.Item
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification

class PreferenceServiceImplTest extends Specification {

    @Shared
    private testItem1 = new ItemGeneric("1", "Teste 1", 100.0, 10,"Eletro");
    private testItem2 = new ItemGeneric("2", "Teste 2", 100.0, 10, "Eletro");

    @Shared
    private List<ItemGeneric> referenceItemList =   [
                                                        testItem1,
                                                        testItem2
                                                    ]



    def "should return erro to get item list"(){
        given:
            ItemRepository mockItemRepository = Mockito.mock(ItemRepository)
            Mockito.when(mockItemRepository.findAll()).thenReturn(null)
            PreferenceService mockPreferenceService = new PreferenceServiceImpl(mockItemRepository)
        when:
            mockPreferenceService.getPreference()
        then:
            thrown(RuntimeException)
    }

   def "should return preference DTO"(){
        given:
            ItemRepository mockItemRepository = Mockito.mock(ItemRepository)
            Mockito.when(mockItemRepository.findAll()).thenReturn(referenceItemList)
            PreferenceService mockPreferenceService = new PreferenceServiceImpl(mockItemRepository)

            Preference preference = new Preference()
            Preference preferenceMock = Mockito.mock(Preference.class)

            Item item = new Item().setId(testItem1.getId().toString())
                                    .setTitle(testItem1.getTitle())
                                    .setQuantity(testItem1.getQuantity())
                                    .setCategoryId(testItem1.getCategory())
                                    .setUnitPrice(testItem1.getPrice() as float);
            preference.appendItem(item)

            Mockito.when(preferenceMock.appendItem(item)).thenReturn(preference)
        when:
            mockPreferenceService.getPreference()
        then:
            null
    }
}
