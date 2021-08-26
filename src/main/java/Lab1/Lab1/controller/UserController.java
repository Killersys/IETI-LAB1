package Lab1.Lab1.controller;

import Lab1.Lab1.data.User;
import Lab1.Lab1.dto.UserDto;
import Lab1.Lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController
{
    private final UserService userService;
    public UserController(@Autowired UserService userService ){
        this.userService = userService;}

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<User>> all(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.all());}

    @GetMapping( "/{id}" )
    @ResponseBody
    public ResponseEntity<User> findById( @PathVariable String id ){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));}

    @PostMapping
    @ResponseBody
    public ResponseEntity<User> create( @RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(new User(userDto)));}

    @PutMapping( "/{id}" )
    @ResponseBody
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ){
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(new User(userDto, id),id));}

    @DeleteMapping( "/{id}" )
    @ResponseBody
    public ResponseEntity<Boolean> delete( @PathVariable String id ){
        try{
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);}
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(false);}}
}
