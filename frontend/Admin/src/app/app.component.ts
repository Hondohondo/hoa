/**
 * The parent component for the angular app.
 * Current holds the functionality of the  navigation bar and header of the UI.
 */
import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

import { AuthenticationService } from '../app/_auth_services/authentication.service';
import { Member } from '../app/_auth_models/Member';
import { Role } from '../app/_auth_models/Role';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'HOA Projectnpm '; //Auto-generated variable that holds a title for the application.
  currentUser: Member; //Holds the Member object that is currently logged in.

  /**
   * Constructor grabs current user information from API.
   * @param router Router object that is used to navigate to different components/pages.
   * @param authenticationService AutheticationService that is used to call a request to the API that deals with authentication.
   */
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }
  /**
   * Checks to see if the current user is an Admin.
   */
  get isAdmin() {
    return this.currentUser && this.currentUser.role === Role.Admin;
  }

  /**
   * Function used to log a user out and then navigates user back to the log in screen.
   * Calls logout() from AuthenticationService.
   */
  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

}
