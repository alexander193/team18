import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminService } from './service/admin.service';
import { PromotionService } from './service/promotion.service';
import { CustomerService } from './service/customer.service';
import { PaymentService } from './service/payment.service';
import { RegisterService } from './service/register.service';

import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule,
MatSidenavModule, MatCheckboxModule , MatDialogModule} from '@angular/material';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatGridListModule} from '@angular/material/grid-list';
import { MatNativeDateModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {MatRadioModule} from '@angular/material/radio';
import { ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';

import { ContractComponent } from './contract/contract.component';
import { EditContractComponent } from './edit-contract/edit-contract.component';
import { LoginAddminComponent } from './login-addmin/login-addmin.component';
import { MainAdminComponent } from './main-admin/main-admin.component';
import { LoginMaidComponent } from './login-maid/login-maid.component';
import { LoginCustomerComponent } from './login-customer/login-customer.component';
import { MainMaidComponent } from './main-maid/main-maid.component';
import { MainCustomerComponent } from './main-customer/main-customer.component';
import { CustomerComponent } from './customer/customer.component';
import { PromotionComponent } from './promotion/promotion.component';
import { PaymentComponent } from './payment/payment.component';
import { SubmitComponent } from './submit/submit.component';
import { TextComponent } from './text/text.component';
import { LendService } from './service/lend.service';
import { RegisterComponent } from './register/register.component';
import { LearnedComponent } from './learned/learned.component';
@NgModule({
  declarations: [
    AppComponent,
    ContractComponent,
    EditContractComponent,
    LoginAddminComponent,
    MainAdminComponent,
    LoginMaidComponent,
    LoginCustomerComponent,
    MainMaidComponent,
    MainCustomerComponent,
    CustomerComponent,
    PromotionComponent,
    PaymentComponent,
    SubmitComponent,
    TextComponent,
    RegisterComponent,
    LearnedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    MatTableModule,
    MatCheckboxModule,
    MatSidenavModule,
    MatIconModule,
    MatGridListModule,
    MatRadioModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatDialogModule
  ],
  providers: [AdminService, PromotionService, CustomerService, PaymentService, LendService, RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
