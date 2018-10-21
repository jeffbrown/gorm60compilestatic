package gormdemo

import groovy.util.logging.Slf4j
import org.grails.orm.hibernate.HibernateDatastore

@Slf4j
class PersonDemo {

    static void main(args) {
        Map configuration = [
                'hibernate.hbm2ddl.auto': 'create-drop',
                'dataSource.url'        : 'jdbc:h2:mem:myDB'
        ]
        def datastore = new HibernateDatastore(configuration, Person)

        Person.withNewSession {
            new Person(firstName: 'Robert', lastName: 'Fripp').save()
            new Person(firstName: 'Ritchie', lastName: 'Blackmore').save()
            new Person(firstName: 'Eric', lastName: 'Clapton').save()
            new Person(firstName: 'Jeff', lastName: 'Beck').save()
            new Person(firstName: 'David', lastName: 'Gilmour').save()
            new Person(firstName: 'Randy', lastName: 'Rhoads').save()
        }

        Person.withNewSession {
            def people = Person.list()
            for (Person p : people) {
                log.info "${p.lastName}, ${p.firstName}"
            }
        }
    }
}