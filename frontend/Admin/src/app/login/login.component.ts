/**
 * Handles functionality for LogIn Component.
 */
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AuthenticationService } from '../_auth_services/authentication.service';

@Component({
    templateUrl: 'login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup; //login FormGroup, answers to submittions with inputs from elements in this group.
    loading = false; //checks to see if page is loading.
    submitted = false; //checks to see if loginForm has been submitted.
    returnUrl: string; //used to route user after login action is completed.
    error = ''; //string to represent error message.

    /**
     * 
     * @param formBuilder Used to create LogIn FormGroup.
     * @param route Used to reroute user based on actions after logging in.
     * @param router Also used to reroute user.
     * @param authenticationService reference to AuthenticationService
     */
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
    ) {
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) {
            this.router.navigate(['/home']);
        }
    }

    /**
     * Builds a loginForm using two input elements of username and password.
     */
    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    /**
     * Called when login button is clicked.
     * Calls login from authenticationSerive and sends back the username and password to be validated by API.
     * Once the promise is completed and user can be logged on, it will reroute user to '/' or this.returnURL which sends user to the home page.
     */
    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authenticationService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}

