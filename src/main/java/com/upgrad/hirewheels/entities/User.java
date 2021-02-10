package com.upgrad.hirewheels.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id",length = 10)
    private int userid;

    @Column(name="first_name",length = 50,nullable = false)
    private String firstName;

    @Column(name="last_name", length = 50)
    private String lastName;

//    @Column(length=50,nullable = false)
    private String password;

    @Column(length = 50,nullable = false,unique = true)
    private String email;


    @Column(length = 10,nullable = false,unique = true)
    private String mobileNo;

    @Column(length = 10)
    private double walletMoney;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Booking> bookings;

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public double getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(double walletMoney) {
        this.walletMoney = walletMoney;
    }

    @Override
    public String toString(){
        return "users{"+
                "userId="+userid+'\'' +
                ", firstName="+ firstName+'\'' +
                ", lastName="+lastName+'\'' +
                ", password="+password+'\'' +
                ", email="+email+'\'' +
                ", monileNo="+mobileNo+'\''+
                ", wallet="+walletMoney+'\'' +
                ", role="+role+'\'' +
                "}";
    }
}
