package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contact implements Comparable<Contact>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer contactId;
    private String contactCell;
    private String contactHome;
    private String contactEmail;

    private Contact() {
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactCell() {
        return contactCell;
    }

    public void setContactCell(String contactCell) {
        this.contactCell = contactCell;
    }

    public String getContactHome() {
        return contactHome;
    }

    public void setContactHome(String contactHome) {
        this.contactHome = contactHome;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.contactCell = builder.contactCell;
        this.contactHome = builder.contactHome;
        this.contactEmail = builder.contactEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getContactId().equals(contact.getContactId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContactId());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", contactCell='" + contactCell + '\'' +
                ", contactHome='" + contactHome + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contact contact) {
        return this.contactId.compareTo(contact.contactId);
    }

    public static class Builder{

        private Integer contactId;
        private String contactCell;
        private String contactHome;
        private String contactEmail;

        public Builder contactId(Integer value){
            this.contactId = value;
            return this;
        }

        public Builder contactCell(String value){
            this.contactCell = value;
            return this;
        }

        public Builder contactHome(String value){
            this.contactHome = value;
            return this;
        }

        public Builder contactEmail(String value){
            this.contactEmail = value;
            return this;
        }

        public Contact build(){

            return new Contact(this);
        }

        public Builder copy(Contact savedContact) {
            this.contactId = savedContact.contactId;
            this.contactCell = savedContact.contactCell;
            this.contactHome = savedContact.contactHome;
            this.contactEmail = savedContact.contactEmail;

            return this;
        }
    }
}
