import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../../modal/user";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  user: User;

  isUpdateForm : boolean = false

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new User();

    if(this.route.snapshot.params["id"] != undefined && this.route.snapshot.params["id"] != null){
      this.fetchUser(this.route.snapshot.params["id"]);
    }
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  fetchUser(id:number){
    this.userService.findOne(id).subscribe(data => {
      this.user = data;
    });
    this.isUpdateForm  = true
  }

  updateUser(){
    this.userService.update(this.user.id,this.user).subscribe(user=>{
      console.log(user)
    })
  }


  gotoUserList() {
    this.router.navigate(['/users']);
  }

  ngOnInit(): void {

  }

}
