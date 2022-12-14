package no.hvl.dat250.jpa.assignment.web.formobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import no.hvl.dat250.jpa.assignment.models.poll.PollStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class PollCustomizeForm {

    @NotNull
    @Size(max = 254)
    @NonNull
    private String question;

    @NotNull
    @Size(max = 254)
    @NonNull
    private String theme;

    @NotNull
    @NonNull
    private Boolean isPrivate;

    @NotNull
    @NonNull
    private PollStatus activeStatus;

    private Integer code;
}
