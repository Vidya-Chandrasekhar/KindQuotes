import{Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import {Injectable} from '@angular/core';
import {Quote} from "../../model/quote";

@Injectable()
export class HomeService{
    constructor(private _http:Http){

    }

    getAllQuotes() : Observable<any> {
        return this._http.get("/quotes")
            .map(response => response.json());
    }

    addANewQuote(quote: Quote) :  Observable<any> {
      let headers = new Headers({ 'Content-Type': 'application/json' });
      let options = new RequestOptions({ headers: headers });
      return this._http.post("/quote", quote, options)
        .map(this.extractData)
        .catch(this.handleErrorPromise);
    }

  private extractData(res: Response) {
    let body = res.json();
    console.log(body.data || {});
  }

  private handleErrorPromise (error: Response | any) {
    console.error(error.message || error);
    return Promise.reject(error.message || error);
  }


}



