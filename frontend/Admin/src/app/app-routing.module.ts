/**
 * Class that handles the pathing of pages/components and their authentication.
 */
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { TicketComponent } from './ticket/ticket.component';
import { ForumComponent } from './forum/forum.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_auth_helpers/auth.guard';
import { Role } from './_auth_models/Role';
/**
 * routes contains the paths to each of the components.
 * By default '' or empty path will direct user towards HomeComponent.
 * AuthGuard calls the auth.guard.ts from _auth_helpers and checks to see if a user is logged in before directing them to the component/page.
 * Admin component has a role check that only allows this path to be accessed if the user is an Admin.
 */
const routes: Routes = [
  {path: '', component: HomeComponent, canActivate: [AuthGuard]},
  {path:'home', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'ticket', component: TicketComponent, canActivate: [AuthGuard]},
  {path: 'forum', component: ForumComponent, canActivate: [AuthGuard]},
  {path: 'admin', component:AdminComponent, canActivate: [AuthGuard], data: {roles: [Role.Admin]}},
  {path: 'login', component:LoginComponent},
  {path: '**', redirectTo:''}
]

export const appRoutingModule = RouterModule.forRoot(routes);

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
