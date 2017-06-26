/**
 * Created by vidyachandasekhar on 6/25/17.
 */
export class Quote {
  private message: String;

  getMessage(): String {
    return this.message;
  }

  setMessage(value: String) {
    this.message = value;
  }
}
