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

const routes: Routes = [
  {path: '', component: HomeComponent, canActivate: [AuthGuard]},
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
