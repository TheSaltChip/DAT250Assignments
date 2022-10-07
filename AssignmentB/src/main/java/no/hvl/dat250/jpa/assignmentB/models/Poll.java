package no.hvl.dat250.jpa.assignmentB.models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "POLL", schema = "APP")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String theme;

    @OneToOne
    private Votes votes;

    private Boolean isPrivate;
    private Boolean active;
    private LocalDateTime createdDate;

    @ManyToOne(targetEntity = Client.class)
    @NonNull
    @JoinColumn(referencedColumnName = "username")
    private Client owner;

    @Version
    protected Integer version;

    public Poll(@NonNull String name, @NonNull String theme, Boolean isPrivate, LocalDateTime createdDate, @NonNull Client owner) {
        this.name = name;
        this.theme = theme;
        this.isPrivate = isPrivate;
        this.createdDate = createdDate;
        this.owner = owner;
    }

    protected Poll() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Boolean getActive(){
        return active;
    }

    public void setActive(Boolean active){
        this.active = active;
    }
}
