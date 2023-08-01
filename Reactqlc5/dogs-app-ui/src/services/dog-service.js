import http from './axios-common';


export function getAllDogs(){
    return http.get("/dog");
}

export function saveDog(dog){
    return http.post("/dogs", dog)
}