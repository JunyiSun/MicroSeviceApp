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
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { MdButtonModule, MdMenuModule, MdIconModule } from '@angular/material';
import { AppComponent } from './app.component';
import { GroupService } from './group/services/group.service';
import { GroupsComponent } from './group/groups.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ProfileCreateComponent } from './signup/profile-create.component';
import { UserService } from './user/services/user.service';
import { routing } from './app-routing.module';

@NgModule({
    declarations: [
        AppComponent,
        GroupsComponent,
        HeaderComponent,
        LoginComponent,
        LogoutComponent,
        ProfileCreateComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        HttpClientModule,
        HttpModule,
        MdButtonModule,
        MdIconModule,
        MdMenuModule,
        routing
    ],
    providers: [
        GroupService,
        UserService],
    bootstrap: [AppComponent]
})

export class AppModule {}
