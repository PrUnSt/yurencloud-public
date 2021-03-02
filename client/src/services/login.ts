import request from "umi-request";

export async function login() {
   return await request.get("/api/login");
}

export async function getMarket(coinType:string = "BTC_CW") {
   return await request.get("/api/kline", {
      params:{coinType:coinType}
   });
}

export async function getKline(coinType:string = "BTC_CW") {
   return await request.get("/api/market",{
      params:{coinType:coinType}
   });
}
