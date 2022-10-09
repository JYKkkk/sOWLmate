// Styles
import '@mdi/font/css/materialdesignicons.css';
import 'vuetify/styles';
import '@/assets/scss/_index.scss'; // _index.scss를 한번만 불러오면 자동으로 css로 컴파일 해줌

// Vuetify
import { createVuetify } from 'vuetify';

export default createVuetify({
  theme: {
    defaultTheme: 'lightTheme',
    themes: {
      lightTheme: {
        dark: false,
        colors: {
          primary: '#7C58EB', // 보라
          secondary: '#6E9DF5', // 파랑
          info: '#CED4DA', // 회색
          error: '#F04438',
        },
      },
      darkTheme: {
        dark: true,
        colors: {
          'primary': '#52E3C2', // 이건 나중에 수정하기 쉽게 복붙한거 그냥 놔둠
          'page-header-background': '#282831',
          'page-background': '#32323E',
          'table-header': '#2e2e2e',
          'background': '#3F3F4A',
          'header-background': '#4a4a59',
          'info-text': '#99999F',
        },
      },
    },
  },
});
// https://vuetifyjs.com/en/introduction/why-vuetify/#feature-guides
