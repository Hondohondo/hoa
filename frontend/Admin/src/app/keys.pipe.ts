import { PipeTransform, Pipe } from '@angular/core';
/**
 * Pipe that is supposed to separate Key from Values in a JSON response. It is not currently being used.
 */
@Pipe({name: 'keys'})
export class KeysPipe implements PipeTransform{
  transform(value, args:string[]) : any{
    let keys = [];
    for(let key in value) {
      keys.push(key);
    }
    return keys;
  }
}