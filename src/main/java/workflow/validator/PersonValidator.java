package workflow.validator;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import workflow.bean.Person;

@Component
public class PersonValidator {

    /**
     * Spring Web Flow activated validation (validate + ${state}).
     * Validates 'personForm' view state after binding to person.
     */
    public void validatePersonForm(Person person, MessageContext context) {
        if (!StringUtils.hasText(person.getFirstName())) {
            context.addMessage(new MessageBuilder().error().source("firstName").code("person.form.firstName.error").build());
        }

        if (!StringUtils.hasText(person.getLastName())) {
            context.addMessage(new MessageBuilder().error().source("lastName").code("person.form.lastName.error").build());
        }
    }

}
