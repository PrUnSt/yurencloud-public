import { getMarket, getKline } from '@/services/login';
import styles from './index.less';

export default function IndexPage() {

  async function handleKlineClick() {
      // setInterval(async () => {
        let response = await getKline();
        console.log(response, '1111');
      // }, 1500);

     
  } 

  async function handleMarketClick() {
    let response = await getMarket();
    console.log(response, '1111');
    
 } 

  return (
    <div>
      <div className={styles.button_group}>
        <button className={styles.send_button} onClick={handleKlineClick}></button>
        <button className={styles.send_button} onClick={handleMarketClick}></button>
      </div>
    </div>
  );
}
