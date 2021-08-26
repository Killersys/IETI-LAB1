package Lab1.Lab1.data;

import Lab1.Lab1.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String email;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date createdAt;

    public User(String id, String name, String email, String lastName, Date createdAt){
        this.id= id;
        this.name= name;
        this.email= email;
        this.lastName= lastName;}

    public User(UserDto userDto){
        this.id= UUID.randomUUID().toString();
        this.name=userDto.getName();
        this.email= userDto.getEmail();
        this.lastName= userDto.getLastName();
        }
    public User(UserDto userDto, String id) {
        this.id = id;
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getLastName();
    }

    public String getId(){
        return id;}
    public String getName(){
        return name;}
    public String getEmail(){
        return email;}
    public String getLastName(){
        return lastName;}
    public Date getCreatedAt(){
        return createdAt;}
    public void setName(String name){
        this.name = name;}
    public void setEmail(String email){
        this.email = email;}
    public void setLastName(String lastName){
        this.lastName = lastName;}
    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;}
}
