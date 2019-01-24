import { Component, OnInit } from '@angular/core';
import { PromotionService } from '../service/promotion.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})
export class PromotionComponent implements OnInit {
  companys: Array<any>
  maids: Array<any>
  promotionTypes : Array<any>

  views: any = {
    companySelect: '',
    promotionTypeSelect: '',
    discount: '',
    title: '',
    dateStart: '',
    dateEnd: ''

  };
  constructor(private promotionService: PromotionService , private httpClient: HttpClient) { }
   
  ngOnInit() {
    
    this.promotionService.getCompanyName().subscribe(data => {
      this.companys = data;
      console.log(this.companys);
    });

    this.promotionService.getPromotionType().subscribe(data => {
      this.promotionTypes = data;
      console.log(this.promotionTypes);
    });
  
  }
  
  save_func(){
    if(this.views.companySelect === '') {
      alert('กรุณาเลือกบริษัท');
    }else if(this.views.promotionTypeSelect === ''){
      alert('กรุณาเลือกประเภทโปรโมชั่น')
    }
    this.httpClient.post('http://localhost:8080/promotion/' + this.views.companySelect + '/' + this.views.promotionTypeSelect  + '/' + this.views.discount + '/' + this.views.title + '/' + this.views.dateStart+ '/' + this.views.dateEnd, this.views)
         .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('เพิ่มโปรโมชั่นสำเร็จ');
                 location.reload();
             },
             error => {
                  console.log('Rrror', error);
                  alert('เกิดข้อผิดพลาด');
            }
    );
  }
}
