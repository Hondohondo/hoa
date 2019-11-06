import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { Member } from '../_auth_models/Member';
import { UserService} from '../_auth_services/user.service';
import { AuthenticationService } from '../_auth_services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loading = false;
  currentUser: Member;
  userFromApi: Member;

  constructor(private userSerive: UserService, private authenticationService: AuthenticationService) {
    this.currentUser = this.authenticationService.currentUserValue;
   }

  ngOnInit() {
    this.loading = true;
    // this.userSerive.getById(this.currentUser.id).pipe(first()).subscribe(
    //   user=>{
    //     this.loading = false;
    //     this.userFromApi = user;
    //   }
    // )
  }
}
