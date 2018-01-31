/*******************************************************************************
* Copyright (c) 2017 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* IBM Corporation - initial API and implementation
*******************************************************************************/
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { GroupsComponent} from './group/groups.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { Routes, RouterModule } from '@angular/router';
import { ProfileCreateComponent } from './signup/profile-create.component';
import { ProfileEditComponent } from './signup/profile-edit.component';

const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'groups', component: GroupsComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent },
    { path: 'signup', component: ProfileCreateComponent },
    { path: 'profiles/:id/edit', component: ProfileEditComponent }
];

export const routing = RouterModule.forRoot(routes);
