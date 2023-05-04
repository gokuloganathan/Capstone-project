import { Component, OnInit } from '@angular/core';
import {User} from "../../modal/user";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router, Routes} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users !: User[];

  constructor(private route: ActivatedRoute,
              private router: Router,private userService: UserService) {
  }

  ngOnInit() {
    this.refreshUsers()
  }

  refreshUsers(){
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  deleteUser(id:number) {
    this.userService.delete(id).subscribe(user=>{
      this.refreshUsers()
    })
  }

  deleteAllUser(){
    this.userService.deleteAll().subscribe(user=>{
      this.refreshUsers()
    })
  }
}
