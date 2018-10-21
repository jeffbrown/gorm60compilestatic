package gormdemo

import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic

@Entity
@CompileStatic
class Person {
    String firstName
    String lastName
}