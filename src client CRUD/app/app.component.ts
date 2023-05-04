import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "./services/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
title = 'loginApp';

  constructor(private route: ActivatedRoute,
              private router: Router,private userService: UserService) {
  }

  deleteAllUsers(){
    this.userService.deleteAll().subscribe(users=>{
      console.log(users)
    })
    this.router.navigate(['/'])
  }



/*  ngOnInit() {
    this.refreshUsers()
  }

  refreshUsers(){
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  deleteAllUser(){
    this.userService.deleteAll().subscribe(user=>{
      this.refreshUsers()
    })
  }
  */
}
