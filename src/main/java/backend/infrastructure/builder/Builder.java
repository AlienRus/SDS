package backend.infrastructure.builder;

import backend.application.interfaces.in.authentication.IAuthorizer;
import backend.application.interfaces.in.registration.IRegistrator;
import backend.application.interfaces.out.repository.usersRepository.IUsersRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class Builder {

    // @Inject
    // @Default
    // private IUsersRepository usersRepository;

    // @Inject
    // @Default
    // private IAuthorizer authorizer;

    // @Inject
    // @Default
    // private IRegistrator registrator;

    // @Produces
    // @Built
    // public IAuthorizer buildAuthorizer() {
    //     authorizer.injectUsersRepository(usersRepository);
    //     return authorizer;
    // }

    // @Produces
    // @Built
    // public IRegistrator buildRegistrator() {
    //     registrator.injectUsersRepository(usersRepository);
    //     return registrator;
    // }

}