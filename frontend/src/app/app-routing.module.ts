import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
import { RegisterComponent } from './register/register.component';
import { LearnedComponent } from './learned/learned.component';
const routes: Routes = [
  {path: '' , component: LoginAddminComponent},
  {path: 'contract' , component: ContractComponent},
  {path: 'mainAdmin' , component: MainAdminComponent},
  {path: 'editcontract' , component: EditContractComponent},
  {path: 'loginMaid' , component: LoginMaidComponent},
  {path: 'loginCus' , component: LoginCustomerComponent},
  {path: 'mainMaid' , component: MainMaidComponent},
  {path: 'mainCus' , component: MainCustomerComponent},
  {path: 'customer' , component: CustomerComponent},
  {path: 'promotion', component: PromotionComponent},
  {path: 'payment' , component: PaymentComponent},
  {path: 'submit' , component: SubmitComponent},
  {path: 'text' , component: TextComponent},
  {path: 'register' , component: RegisterComponent},
  {path: 'learned' , component: LearnedComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
