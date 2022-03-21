package de.fherfurt.persons.service.core;

import de.fherfurt.faculty.client.transfer.object.FacultyDto;
import de.fherfurt.campus.client.DevCampusService;

/**
 * @author Luisa Oswald
 * class to add person data
 * class to represent and create persons with builder-pattern and puts them into the PersonRepository.
 */
public class Person
{
    /**
     * Persons address
     */
    private String address;

    /**
     * Persons Unique Identifier
     */
    private int personId;

    /**
     * Persons first name
     */
    private String firstname;

    /**
     * Persons last name
     */
    private String lastname;

    /**
     * Persons email
     */
    private String email;

    /**
     * Persons phonenumber
     */
    private String phonenumber;

    /**
     * Persons title
     */
    private String title;

    /**
     * Persons hire date
     */
    private String hireDate;

    /**
     * Persons faculty
     */
    private String faculty;

    /**
     * Flag to determine whether someone is teaching or not
     */
    private Boolean teachingFlag;

    /**
     * Persons room specific
     */
    private String room;

    /**
     * Persons major
     */
    private String major;

    /**
     * Persons immatriculation date
     */
    private  String immatriculationDate;

    /**
     * Persons exmatriculation date
     */
    private  String exmatriculationDate;

    /**
     * Flag to determine whether someone is a tutor
     */
    private  Boolean tutorFlag;

    /**
     * Flag to determine whether someone is a scientific worker
     */
    private  Boolean scientificWorkerFlag;

    /**
     * Persons job title
     */
    private  String jobTitle;

    /**
     * Flag to determine if the data will be deleted
     */
    private  Boolean deletedFlag;

    /**
     * Constructor
     */
    private Person(int personId, String firstname, String lastname, String address, String email, String phonenumber, String title, String hireDate,
                   String faculty, Boolean teachingFlag, String room, String major, String immatriculationDate,
                   String exmatriculationDate, Boolean tutorFlag, Boolean scientificWorkerFlag, String jobTitle, Boolean deletedFlag) {
        this.personId = personId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.title = title;
        this.hireDate = hireDate;
        this.faculty = faculty;
        this.teachingFlag = teachingFlag;
        this.room = room;
        this.major = major;
        this.immatriculationDate = immatriculationDate;
        this.exmatriculationDate = exmatriculationDate;
        this.tutorFlag = tutorFlag;
        this.scientificWorkerFlag = scientificWorkerFlag;
        this.jobTitle = jobTitle;
        this.deletedFlag = deletedFlag;
    }

    //Singleton
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Class using builder pattern that holds all the information of a person
     */
    public static class Builder {

        private int personId;
        private String firstname;
        private String lastname;
        private String address;
        private String email;
        private String phonenumber;
        private String title;
        private String hireDate;
        private String faculty;
        private Boolean teachingFlag;
        private String room;
        private String major;
        private String immatriculationDate;
        private String exmatriculationDate;
        private Boolean tutorFlag;
        private Boolean scientificWorkerFlag;
        private String jobTitle;
        private Boolean deletedFlag;

        private Builder() {
        }

        /**
         * Function that creates a person from the data
         * @return new person instance
         */
        public Person build() {
            return new Person(personId, firstname, lastname, address, email, phonenumber, title, hireDate, faculty, teachingFlag,
                    room, major, immatriculationDate, exmatriculationDate, tutorFlag, scientificWorkerFlag, jobTitle, deletedFlag);
        }

        /**
         * Function to set a persons unique Identifier
         */
        public Builder setPersonID(int personId)
        {
            this.personId = personId;
            return this;
        }

        /**
         * Function to set a persons first name
         */
        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        /**
         * Function to set a persons last name
         */
        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        /**
         * Function to set a persons address
         */
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Function to set a persons email
         */
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         * Function to set a persons phonenumber
         */
        public Builder setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        /**
         * Function to set a persons title
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Function to set a persons hire date
         */
        public Builder setHireDate(String hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        /**
         * Function to set a persons faculty
         */
        public Builder setFaculty(String faculty) {
            this.faculty = build().checkFacultyIsValid(faculty);
            return this;
        }

        /**
         * Function to set a person teaching flag
         */
        public Builder setTeachingFlag(Boolean teachingFlag) {
            this.teachingFlag = teachingFlag;
            return this;
        }

        /**
         * Function to set a persons room after checking
         */
        public Builder setRoom(String room) {
            if(Person.checkIfRoomExist(room))
            this.room = room;
            return this;
        }

        /**
         * Function to set a persons major
         */
        public Builder setMajor(String major) {
            this.major = major;
            return this;
        }

        /**
         * Function to set a persons immatriculation date
         */
        public Builder setImmatriculationDate(String immatriculationDate) {
            this.immatriculationDate = immatriculationDate;
            return this;
        }

        /**
         * Function to set a persons exmatricualtion date
         */
        public Builder setExmatriculationDate(String exmatriculationDate) {
            this.exmatriculationDate = exmatriculationDate;
            return this;
        }

        /**
         * Function to set a persons tutor flag
         */
        public Builder setTutorFlag(Boolean tutorFlag) {
            this.tutorFlag = tutorFlag;
            return this;
        }

        /**
         * Function to set a persons scientific worker flag
         */
        public Builder setScientificWorkerFlag(Boolean scientificWorkerFlag) {
            this.scientificWorkerFlag = scientificWorkerFlag;
            return this;
        }

        /**
         * Function to set a persons job title
         */
        public Builder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        /**
         * Function to set the deleted flag
         */
        public Builder setDeletedFlag(Boolean deletedFlag) {
            this.deletedFlag = deletedFlag;
            return this;
        }


        /**
         * getters for all attributes
         */

        public int getPersonID() {
            return personId;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public String getAddress() {
            return address;
        }

        public String getEmail() {
            return email;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public String getTitle() {
            return title;
        }

        public String getHireDate() {
            return hireDate;
        }

        public String getFaculty() {
            return faculty;
        }

        public Boolean getTeachingFlag() {
            return teachingFlag;
        }

        public String getRoom() {
            return room;
        }

        public String getMajor() {
            return major;
        }

        public String getImmatriculationDate() {
            return immatriculationDate;
        }

        public String getExmatriculationDate() {
            return exmatriculationDate;
        }

        public Boolean getTutorFlag() {
            return tutorFlag;
        }

        public Boolean getScientificWorkerFlag() {
            return scientificWorkerFlag;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public Boolean getDeletedFlag() {
            return deletedFlag;
        }

    }

    /**
     * Function to create an employee with the needed parameters from person
     * @return a new person instance that only requires the specific parameters for an employee
     */
    //only needed for other employees
    public static Person otherEmployee(int personId, String firstname,String lastname,String email,String jobTitle, boolean deletedFlag){
        return builder().setPersonID(personId).setFirstname(firstname).setLastname(lastname).setEmail(email).setJobTitle(jobTitle).setDeletedFlag(deletedFlag).build();
    }

    /**
     * Function to create a lecturer with the needed parameters from person
     * @return a new person instance that only requires the specific parameters for a lecturer
     */
    //only needed for lecturers
    public static Person lecturer(int personId, String firstname,String lastname,String email,String phonenumber, String title, String hireDate, String faculty, Boolean teachingFlag, String room, boolean deletedFlag){
        return builder().setPersonID(personId).setFirstname(firstname).setLastname(lastname).setEmail(email).
                setPhonenumber(phonenumber).setTitle(title).setHireDate(hireDate).setFaculty(faculty).setRoom(room).
                setTeachingFlag(teachingFlag).setRoom(room).setDeletedFlag(deletedFlag).build();
    }

    /**
     * Function to create a student with the needed parameters from person
     * @return a new person instance that only requires the specific parameter for a student
     */
    //only needed for students
    public static Person student(int personId, String firstname,String lastname,String email,String major, String immatriculationDate, String exmatriculationDate, Boolean tutorFlag, Boolean scientificWorkerFlag, boolean deletedFlag){
        return builder().setPersonID(personId).setFirstname(firstname).setLastname(lastname).setEmail(email).setMajor(major).setImmatriculationDate(immatriculationDate).setExmatriculationDate(exmatriculationDate).setTutorFlag(tutorFlag).setScientificWorkerFlag(scientificWorkerFlag).setDeletedFlag(deletedFlag).build();
    }


    /**
     * @author Tran Anh Hoang
     * overrided toString-method. The strings are easier to oparate with and to debug
     */
    @Override
    public String toString()
    {
        return "Person: {" +
                "personId='" + personId + '\'' +
                " ,firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", deletedFlag='" + deletedFlag + '}' + '\n';
                /*
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", title='" + title + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", faculty=" + faculty +
                ", teachingFlag=" + teachingFlag +
                ", room='" + room + '\'' +
                ", major='" + major + '\'' +
                ", immatriculationDate='" + immatriculationDate + '\'' +
                ", exmatriculationDate='" + exmatriculationDate + '\'' +
                ", tutorFlag=" + tutorFlag +
                ", scientificWorkerFlag=" + scientificWorkerFlag +
                ", jobTitle='" + jobTitle + '\'' +
                */
    }


    /**
     * @author Tran Anh Hoang
     * all getters and setters for Person
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Boolean getTeachingFlag() {
        return teachingFlag;
    }

    public void setTeachingFlag(Boolean teachingFlag) {
        this.teachingFlag = teachingFlag;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        if (Person.checkIfRoomExist(room)){
            this.room = room ;
        }
        else {
            this.room = null;
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getImmatriculationDate() {
        return immatriculationDate;
    }

    public void setImmatriculationDate(String immatriculationDate) {
        this.immatriculationDate = immatriculationDate;
    }

    public String getExmatriculationDate() {
        return exmatriculationDate;
    }

    public void setExmatriculationDate(String exmatriculationDate) {
        this.exmatriculationDate = exmatriculationDate;
    }

    public Boolean getTutorFlag() {
        return tutorFlag;
    }

    public void setTutorFlag(Boolean tutorFlag) {
        this.tutorFlag = tutorFlag;
    }

    public Boolean getScientificWorkerFlag() {
        return scientificWorkerFlag;
    }

    public void setScientificWorkerFlag(Boolean scientificWorkerFlag) {
        this.scientificWorkerFlag = scientificWorkerFlag;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public void setFacultyByName(String facultyName) {
       this.faculty = checkFacultyIsValid(facultyName);
    }

    /**
     * @author Tran Anh Hoang
     * Overrided method from FacultyClient, to check the faculty input
     * @param facultyName faculty from person
     * @return checked faculty string
     */
    public String checkFacultyIsValid(String facultyName){
        String result;
        switch (facultyName)
        {
            case "Gebaeudetechnik und Informatik" -> result = FacultyDto.GTI.toString();
            case "Landschaftsarchitektur, Gartenbau und Forst" -> result = FacultyDto.LGF.toString();
            case "Wirtschaft-Logistik-Verkehr" -> result = FacultyDto.WLV.toString();
            case "Bauingenieurwesen und Konservierung/Restaurierung" -> result = FacultyDto.BKR.toString();
            case "Architektur und Stadtplanung" -> result = FacultyDto.ASP.toString();
            case "Angewandte Sozialwissenschaften" -> result = FacultyDto.ASW.toString();
            default -> result = FacultyDto.NULL.toString();
        }
        return result;
    }

    /**
     * @author Tran Anh Hoang
     * @param room the room of the person
     * @return returns boolean if the room exists or not
     */
    public static boolean checkIfRoomExist(String room){
        return DevCampusService.getInstance().checkRoomExist(room);
    }
}