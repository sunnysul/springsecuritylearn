import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'basic-auth-app';


  url = "http://localhost:9595/authonly";
  username = "xyz";
  password = "123";


  constructor(private http: HttpClient) {
    console.log('constructor');


  }


  submit() {
    console.log('submit');

    // Basic Auth Implementation
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa(this.username + ':' + this.password)
    });
    this.http.get(this.url, { headers: headers }).subscribe({
      next: data => console.log(data),
      error: error => console.error(error)
    })

  }
}
