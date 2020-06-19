package com.Bridgelabz;

import java.util.Comparator;

public  class Person {

    private String firstName;
        private String lastName;
        public String city;
        public String state;
        public String zipCode;
        public String phoneNumber;

        public Person(String firstName, String lastName, String city, String state, String zipCode, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.phoneNumber = phoneNumber;

        }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }


        public static Comparator<Person> nameSort=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String firstName=o1.getFirstName();
                String firstNameSecond=o2.getFirstName();
                return firstName.compareTo(firstNameSecond);
            }
        };
        public static Comparator<Person> citySort=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String cityOne=o1.getCity();
                String citySecond=o2.getCity();

                return cityOne.compareTo(citySecond);
            }
        };
        public static Comparator<Person> stateSort=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String stateOne=o1.getState();
                String stateSecond=o2.getState();
                return stateOne.compareTo(stateSecond);
            }
        };
            public static Comparator<Person> zipSort=new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                String zipOne=o1.getZipCode();
                String zipSecond=o2.getZipCode();
                return zipOne.compareTo(zipSecond);
            }
        };

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zipCode=" + zipCode +
                    ", phoneNumber=" + phoneNumber +
                    '}';
        }
    }