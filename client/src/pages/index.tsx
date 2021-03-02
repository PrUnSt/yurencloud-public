import { login } from '@/services/login';
import styles from './index.less';

export default function IndexPage() {

  async function send() {
     let response = await login();
     console.log(response, '1111');
     
  } 

  return (
    <div>
      <div className={styles.button_group}>
        <button className={styles.send_button} onClick={send}></button>
      </div>
    </div>
  );
}
