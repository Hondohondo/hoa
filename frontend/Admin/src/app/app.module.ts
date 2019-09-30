import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
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
//import { FlatpickrModule } from 'angularx-flatpickr';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TicketComponent,
    ForumComponent,
    KeysPipe,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    AlertModule.forRoot(),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
