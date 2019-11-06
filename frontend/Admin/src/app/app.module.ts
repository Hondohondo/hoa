/**
 * This is the TypeScript file that handles all components, modules, objects, classes, etc.. of an Angular project.
 * This is the brains of the Angular App.
 */
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { AlertModule } from 'ngx-bootstrap';
import { TicketComponent } from './ticket/ticket.component';
import { ForumComponent } from './forum/forum.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PipeTransform, Pipe } from '@angular/core';
import { KeysPipe } from './keys.pipe';
import { AdminComponent } from './admin/admin.component';
import { ReactiveFormsModule, FormsModule, Validators } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AlertComponent } from './_auth_components/alert.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav.component';
import { JwtInterceptor } from '../app/_auth_helpers/jwt.interceptor';
import { ErrorInterceptor } from '../app/_auth_helpers/error.interceptor';
//import { fakeBackendProvider } from '../app/_auth_helpers/fake-backend';


//import { FlatpickrModule } from 'angularx-flatpickr';

/**
 * declarations - represents all components, injectables, pipes, etc.. used within the angular project.
 * imports - Specific libraries/modules that are being utilized by one or many of the declarations. (Modules are located in node_modules folder)
 * providers - currently holds HTTPInterceptors that handles errors from server and checks if a user is logged on.
 * bootstrap - AppComponent is the parent component. Lists what components will be bootstrapped.
 */
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TicketComponent,
    ForumComponent,
    KeysPipe,
    AdminComponent,
    AlertComponent,
    LoginComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    AlertModule.forRoot(),
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    //fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
