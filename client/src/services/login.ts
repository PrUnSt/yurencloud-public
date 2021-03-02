import request from "umi-request";

export async function login() {
   return await request.get("/api/login");
}
