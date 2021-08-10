package br.com.mytech.dtos.response

import spock.lang.Shared
import spock.lang.Specification

class PreferenceDTOTest extends Specification {



    @Shared
    PreferenceDTO referencePreferenceDTO = new PreferenceDTO("initPoint", "sendBoxInitPoint")

    def "should return string of PreferenceDTO" (){
        given:
            PreferenceDTO preferenceDTO = new PreferenceDTO("initPoint", "sendBoxInitPoint")
        when:
            def result = preferenceDTO.toString()
        then:
            result == referencePreferenceDTO.toString()
    }

    def "should return hash of PreferenceDTO" (){
        given:
            PreferenceDTO preferenceDTO = new PreferenceDTO("initPoint", "sendBoxInitPoint")
        when:
            def result = preferenceDTO.hashCode()
        then:
            result == referencePreferenceDTO.hashCode()
    }

    def "should verify equal object with parameters" (){
        given:
        PreferenceDTO preferenceDTO = new PreferenceDTO(inputInitPoint, inputSendBox)
        when:
        def result = preferenceDTO.equals(referencePreferenceDTO)
        then:
        result == expectedResult
        where:
        inputInitPoint          | inputSendBox          || expectedResult
        "initPoint"             | "sendBoxInitPoint"    || true
        ""                      | "sendBoxInitPoint"    || false
        "initPoint"             | ""                    || false
    }


    def "should verify equal object" (){
        given:
            PreferenceDTO preferenceDTO = new PreferenceDTO("initPoint", "sendBoxInitPoint")
        when:
            def result = preferenceDTO.equals(inputData)
        then:
            result == expectedResult
        where:
            inputData               | expectedResult
            Object                  | false
            null                    | false
            referencePreferenceDTO  | true
    }




}
