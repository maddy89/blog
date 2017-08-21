package com.example.user

import spock.lang.Specification

/**
 * @author Madhawa Bandara.
 */
class UserServiceTest extends Specification {

    def userService = new UserService()
    def mockRepo = Mock(UserRepository)

    def setup() {
        userService.setUserRepository(mockRepo)
    }

    def "find user by id should return a user when user exists"() {
        given:
        def userId = "JOHNDOE"
        def user = new User(userId: userId, email: "jd@example.com")

        and:
        def mockRepo = Mock(UserRepository)
        mockRepo.findUserById(userId) >> user
        userService.setUserRepository(mockRepo)

        when:
        def result = userService.findUserById(userId)

        then:
        result.userId == userId

    }

    def "throw exception when user not found"() {
        given:
        def userId = "JOHNDOE"
        def user = new User(userId: userId, email: "jd@example.com")

        and:
        def mockRepo = Mock(UserRepository)
        userService.setUserRepository(mockRepo)
        // underscore = any
        mockRepo.findUserById(_ as String) >> {
            throw new IllegalArgumentException("No such user") // can put anything here
        }

        when:
        def result = userService.findUserById(userId)

        then:
        thrown IllegalArgumentException

    }

    def "when user id not given throw an exception"() {
        when:
        userService.save(new User())

        then:
        thrown IllegalArgumentException

    }

    def "when userId is < 4 chars throw an exception"() {
        given:
        def userId = "JD"
        def user = new User(userId: userId, email: "jd@example.com")

        when:
        userService.save(user)

        then:
        IllegalArgumentException ex = thrown()
        ex.getMessage().toLowerCase().contains("invalid userid")

    }

    def "when user id > 4 save user"() {
        given:
        def userId = "JOHNDOE"
        def user = new User(userId: userId, email: "jd@example.com")

        and:
        //mockRepo.save(user) >> user //can be moved to then: clause
        //mockRepo.save(_ as User) >> { User u -> u } //another way of doing it

        when:
        def savedUser = userService.save(user)

        then:
        1 * mockRepo.save(user) >> user //1 *  1 time, _ * any times, ) * zero times
        savedUser.userId == user.userId

    }


}
