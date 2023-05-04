import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {User} from "../modal/user";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  findOne(id: any): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/${id}`);
  }

  public save(user: User):Observable<any> {
    return this.http.post<User>(this.usersUrl, user);
  }

  update(id: any, user: any): Observable<any> {
    return this.http.put(`${this.usersUrl}/${id}`,user);
  }

  delete(id: any): Observable<any> {
    //console.log(this.http.delete(`${this.usersUrl}/${id}`))
    return this.http.delete(`${this.usersUrl}/${id}`);
  }

  deleteAll():Observable<any> {
    return this.http.delete(this.usersUrl)
  }
}
