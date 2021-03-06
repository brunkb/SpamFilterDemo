import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorsSpec extends Specification {

    @Unroll
    def "test evaluateResult"() {

        when:
        Result r = new Result(actualType: actualType, calculatedType: calculatedType)
        ResultType rt = Calculators.evaluateResult(r)

        then:
        rt == expected

        where:

        expected                  |   actualType             |  calculatedType
        ResultType.CORRECT        |   Classification.SPAM    |  Classification.SPAM
        ResultType.CORRECT        |   Classification.HAM     |  Classification.HAM
        ResultType.FALSE_NEGATIVE |   Classification.SPAM    |  Classification.HAM
        ResultType.FALSE_POSITIVE |   Classification.HAM     |  Classification.SPAM
        ResultType.MISSED_SPAM    |   Classification.SPAM    |  Classification.UNSURE
        ResultType.MISSED_HAM     |   Classification.HAM     |  Classification.UNSURE

    }


    @Ignore
    def "test score function"() {

        when:
            Calculators.score([[spamFrequency]])
        then:
            true == true


    }



}
