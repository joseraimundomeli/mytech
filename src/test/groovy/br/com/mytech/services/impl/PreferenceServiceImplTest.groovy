package br.com.mytech.services.impl


import br.com.mytech.dtos.response.PreferenceDTO
import br.com.mytech.factory.PreferenceFactory
import br.com.mytech.models.ItemCustom

import br.com.mytech.repositories.ItemRepository
import br.com.mytech.services.PreferenceService
import br.com.mytech.services.impl.PreferenceServiceImpl
import com.mercadopago.resources.Preference
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification

class PreferenceServiceImplTest extends Specification {


    private testItem1 = new ItemCustom("1", "Teste 1", 100.0, 10,"Eletro");
    private testItem2 = new ItemCustom("2", "Teste 2", 100.0, 10, "Eletro");

    @Shared
    private List<ItemCustom> referenceItemList;

    def setup(){
        referenceItemList =   [ testItem1, testItem2]
    }

    def "should return error to get item list"(){
        given:
            ItemRepository mockItemRepository = Mockito.mock(ItemRepository)
            Mockito.when(mockItemRepository.findAll()).thenReturn(null)
        PreferenceService preferenceService = new PreferenceServiceImpl(mockItemRepository, null)
        when:
            preferenceService.getPreference()
        then:
            thrown(RuntimeException)
    }

   def "should return preference DTO"(){
        given:
            PreferenceDTO referencePreferenceDTO = new PreferenceDTO("InitPointURL", "SendBoxInitPointURL")

            Preference mockPreference = Mockito.mock(Preference)
            ItemRepository mockItemRepository = Mockito.mock(ItemRepository)
            PreferenceFactory mockPreferenceFactory = Mockito.mock(PreferenceFactory)

            Mockito.when(mockItemRepository.findAll()).thenReturn(referenceItemList)
            Mockito.when(mockPreferenceFactory.createPreferenceCustom(referenceItemList)).thenReturn(mockPreference)
            Mockito.when(mockPreference.initPoint).thenReturn("InitPointURL")
            Mockito.when(mockPreference.sandboxInitPoint).thenReturn("SendBoxInitPointURL")

            PreferenceService preferenceService = new PreferenceServiceImpl(mockItemRepository, mockPreferenceFactory)
        when:
            def result = preferenceService.getPreference()
        then:
            result.equals(referencePreferenceDTO)
    }

    def "shuld create a PreferenceService by defaul constructor" (){
        when:
            def expectedPreferenceService = new PreferenceServiceImpl()
        then:
            expectedPreferenceService != null
    }
}
