package br.com.mytech

import br.com.mytech.models.ItemGeneric
import br.com.mytech.repositories.ItemRepository
import br.com.mytech.services.ItemService
import br.com.mytech.services.impl.ItemServiceImpl
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification
import sun.invoke.empty.Empty

import javax.swing.text.html.Option

class ItemServiceImplTest extends Specification {

    private final String REFERENCE_ID = "1";

    @Shared
    private ItemGeneric mockItemReference =   new ItemGeneric("1", "Fusquinha Preto", 7000.0, 10, "Eletro")


    def "should return  a item" (){
        given:
            ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository)
            Mockito.when(itemRepositoryMock.findById(REFERENCE_ID)).thenReturn(Optional.of(mockItemReference))
            ItemService itemServiceMock = new ItemServiceImpl(itemRepositoryMock)
        when:
            itemServiceMock.findById("1")
        then:
            mockItemReference
    }

    def "should empty list error to try return a item" (){
        given:
            ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository)
            Mockito.when(itemRepositoryMock.findById(REFERENCE_ID)).thenReturn(Optional.ofNullable(null))
            ItemService itemServiceMock = new ItemServiceImpl(itemRepositoryMock)
        when:
            itemServiceMock.findById("1")
        then:
            thrown(RuntimeException)
    }

    def "should return a item list" (){
        given:
            ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository)
            Mockito.when(itemRepositoryMock.findAll()).thenReturn([mockItemReference])
            ItemService itemServiceMock = new ItemServiceImpl(itemRepositoryMock)
        when:
            itemServiceMock.list()
        then:
            [mockItemReference]
    }

    def "should erro to try return a null item list" (){
        given:
            ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository)
            Mockito.when(itemRepositoryMock.findAll()).thenReturn(null)
            ItemService itemServiceMock = new ItemServiceImpl(itemRepositoryMock)
        when:
            itemServiceMock.list()
        then:
            thrown(RuntimeException)
    }
}
