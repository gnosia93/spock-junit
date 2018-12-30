package io.startup.spockjunit

import static org.junit.jupiter.api.Assertions.*

import spock.lang.Specification

class FirstTest extends Specification {

	
	def "one plus one should equal two" () {
		expect:
		1 + 1 == 2
		
	}
	

	def "2 더하기 2는 4이다" () {
		given:
			int left = 2
			int right = 2
		
		when:
			int result = left + right
			
		then:
			result == 4	
	}
	
	
	def "should be able to remove from list" () {
		given:
			def list = [1, 2, 3, 4]
		
		when:
			list.remove(0)	
			
		then:
			list == [2, 3, 4]	
	}	
	
	def "should get an index out of bounds when removeing.."() {
		given:
			def list = [1, 2, 3, 4]
			
		when:
			list.remove(20)	
		
		then:
			thrown(IndexOutOfBoundsException)
			list.size()== 4
	}
	
	
	
}
