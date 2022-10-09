### 1. ESLint와 prettier 적용

- eslint?
  
  ESLint는 더 일관성있게 코드를 작성하고 버그를 식별 및 회피할 목적으로 ECMAScript / JavaScript 코드에서 발견된 패턴을 개발자에게 알려주기 위한 도구
  
  - vue-cli v3.xx 이상 -> 자동 eslint 추가됨

- prettier
  
  ESLint가 제공하는 formatting보다 더 강화된 formatting을 제공
  
  ESLint가 자동으로 고쳐주는 것보다 더 많은 범위내에서 formatting을 고쳐줌

#### 1-1) dev 의존성에 prettier와 eslint와 prettier를 통합으로 사용할 패키지 두 개 추가

`npm i prettier eslint-config-prettier eslint-plugin-prettier --save-dev`

- eslint-config-prettier : Prettier 설정과 충돌 나는 ESLint의 설정을 비활성화하는 역할

- eslint-plugin-prettier : ESLint 안에서 Prettier 검사를 실행하도록 설정 -> Prettier 검사 결과를 ESLint 검사 결과처럼 보여주도록 함

#### 1-2) .eslintrc.json

```json
{
  "extends": ["plugin:prettier/recommended"],
  "plugins": ["prettier"],
  "rules": {
    "prettier/prettier": "error"
}
}
```

- `"extends": ["prettier"]` : Prettier 설정과 충돌 나는 ESLint의 설정을 비활성화 → eslint-config-prettier 패키지의 기능
- `"plugins": ["prettier"]` : eslint-plugin-prettier 플러그인을 등록 → eslint-plugin-prettier 패키지의 기능
- `"prettier/prettier": "error"` : ESLint 안에서 Prettier 검사를 실행하도록 설정. → eslint-plugin-prettier 패키지의 기능

#### 1-3) .prettierrc

```json
{    
  "printWidth": 80,
  "singleQuote": true,
  "quoteProps": "consistent",
  "arrowParens": "always",
  "semi": true,
  "trailingComma": "all",
  "tabWidth": 2,
  "useTabs": false,
  "endOfLine": "auto"
}
```

- `"printWidth": 80` : 한 줄의 최대 길이를 80글자로 제한, 넘어가면 개행

- `"singleQuote": true` : 문자열 표현 시 작은따옴표를 사용하도록 제한

- `"quoteProps": "consistent"` : 객체 내에서 key에 따옴표 적용 여부를 일관되게 설정

- `"arrowParens": "always"` : 화살표 함수에서 매개변수 전달 시 항상 괄호 사용

- `"semi": true` : 코드 마지막에 항상 세미콜론 사용

- `"trailingComma": "all"` :  트레일링 콤마 항상 사용 => 원소의 순서를 재배열하거나 이후 새로운 원소를 추가할 때에 보다 깔끔한 변경사항을 가질 수 있음

- `"tabWidth": 2` : 들여쓰기 너비 2

- `"useTabs": false` : 탭 사용 여부

- `"endOfLine": "auto"` : 기존의 CRLF, LF 문자를 유지 / 이를 설정해주지 않으면 디폴트 값인 `"lf"`으로 설정되기 때문에 개행 문자로 CRLF를 사용하는 Windows에서는 에러가 발생

#### 1-4) default formatter 지정 + 저장을 눌렀을 때 자동 포매팅

   `ctrl + shift + p` => `Preferences: Open Settings`

```json
// settings.json
    //기본 포멧팅 설정
    // prettier 파일이 없을 때 VS Code prettier 플러그인에 내장되어있는 default 값으로 포매팅 
    "editor.defaultFormatter": "esbenp.prettier-vscode",
    //자동포멧팅
    "editor.codeActionsOnSave": {
        "source.fixAll.eslint": true
    },
    "editor.formatOnSave": false,
```

#### +) eslint + prettier을 적용하고, 자동 수정을 적용했을 때 `module.exports`에 오류가 남

why? )

- 노드는 코드를 모듈로 만들 수 있다는 점에서 브라우저의 자바스크립트와 다름

- 아래의 `require, module.exports` 는 ES2015 이전의 문법이고, ES2015 버전의 문법은 `import, export default` 

헤결 ) 

```
// .eslintrc.json
"env": {
    "node": true 
  },
```

추가 했더니 해결됨!

-------------------------------------------------------------------------------------------------------------------------

### 2. vuetify & scss 설정

> Vuetify에서 scss를 이용해 특정 스타일을 지정하고 바꿀 수 있고, 프로젝트에서 css 대신 scss를 이용해 변수, mixin, placeholder 등을 통해 간편하게 스타일을 적용 할 예정
> 
> [Vuetify — A Material Design Framework for Vue.js](https://vuetifyjs.com/en/features/sass-variables/)

**폴더 구조**

- **layouts** : 웹페이지 전체를 구성하는 레이아웃에 대한 CSS
- **pages** : 로그인, 매인화면 등등 개별로 존재하는 화면에 대한 CSS
- **templates** : 여러 개의 Components로 구현된 해당 웹사이트에 특화된 템플릿에 대한 CSS
- **components** : 버튼, 인풋박스, 컨테이너 등등.. 개별 컴포넌트에 대한 CSS
- **commons.scss** : 웹사이트에 공통적으로 적용되는 CSS
- **_index.scss** : 위의 모든 SCSS를 한곳으로 모으는 CSS (단, variables.scss는 여기에 포함되지 않음)
- **variables.scss** : 모든 SCSS 파일에서 사용할 변수에 대한 정의만 작성

#### 2-1) variables.scss

> 프로젝트 전체에 적용되는 변수에 대해 정의
> 
> 컴포넌트 갯수 만큼 실행되기 때문에 변수에 대해서만 정의해야 함(실제 CSS에 대한 적용은 _index.scss에 작성)
> 
> vue.config.js에 설정

- path: `src/styles/variables.scss`

- `src/styles/`폴더 안에 `variables.scss`를 만든 뒤 vuetify component들의 스타일을 지정하면 vuetify에서 알아서 불러옴

---------------------

**전역 폰트 : AppleSDGothicNeo**

- Supported Weights

`100` **Thin**  
`200` **UltraLight**  
`300` **Light**  
`400` **Medium**  
`500` **Regular**  
`600` **SemiBold**  
`700` **Bold**  
`800` **ExtraBold**  
`900` **Heavy**

- Font Families

`Apple Sandoll Gothic Neo`

- HTML

```html
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/font-applesdgothicneo@1.0/all.min.css">
```

- CSS

```css
@import "//cdn.jsdelivr.net/npm/font-applesdgothicneo@1.0/all.min.css";
```

------------------------------------------

------------------------------------

### 3. Git과의 싸움

#### merge conflict

>  resolve conflicts 가 있다면 들어가서 바로 해결하면 되지만, **merge locally**만 활성화 되어 있는 경우에는 어떻게?

방법 1) 내 로컬 저장소에 rebase 해와 충돌 해결

1. 브랜치 이동 : `git switch [feature 브랜치 이름]` 

2. git fetch를 이용하여 원격 저장소 최신 이력 확인
   
   `git fetch`

3. target branch(develop)에 대해 rebase 수행하여 충돌 메세지 보기
   
   `git rebase origin/[target branch]`
   
   ----------
   
   merge vs rebase 
   
   - 모두 한 브랜치에서 다른 브랜치로 합치는 방법
   
   - 실행결과는 같지만, 커밋 히스토리가 달라짐
   
   - merge는 쉽고 안전하지만 커밋히스토리가 지저분할 수 있는 반면 rebase는 잘 모르고 사용할 경우 위험할 수 있어 까다롭지만 커밋히스토리를 깔끔하게 관리 가능
   
   ------------------------------------------------------------------
   
   rebase 하고 나면 target branch가 base가 되고, 임시 저장 공간에 저장하게 됨 (임시공간은 `patch`)

4. 충돌 난 블럭을 찾아 수정하고 파일 저장

5. git 에 변경 사항 stage `git add .`

6. 변경 사항 커밋

7. rebase 계속함
   
   `git rebase --continue`
   
   작업 중단 : `git rebase --abort`

8. 이 후 feature 브랜치 변경 사항을 강제로 push => 권장은 안하는 내용
   
   `git push --force origin [feature 브랜치 이름]`

방법 2) 내 로컬 저장소에 merge 하고 싶은 gitlab을 pull 해와 로컬에서 충돌 해결

------------------------------------------------------------

결론) 방법 1로 하고 merge를 시도했지만, 또 충돌

이미 수정을 많이 거친 상태라 pull 받아도 conflict도 안 나오고 이상했음

무엇보다 dev 와 비교해서 고칠 순 있었지만, 굳이 건들이지 않아도 되는 파일의 커밋 이력을 내 merge 이력으로 덮어씌우는 것이 마음에 걸림

branch를 새로 파서 간단한 작업이기 때문에 재진행 => 바로 성공!

**branch를 너무 오래 놔두지 말자 / 더 소규모 단위로 branch를 구성하여 merge 해두자**

-----------------------------------------------

### 4. axios get은 body가 없다.

- 보안을 위해 서버의 rest api url을 대폭 수정 후, 회원 관리에 반영하여 수정

- axios get을 하는데, `Required request body is missing` 에러가 자꾸 뜸

- 분명히 body에 data를 실어서 보냈는데, 왜지? 
  
  => 답은, **axios get에는 body가 없었던 것**
  
  그래서 params에 넣어 보내거나, url에 붙여 보내면, 백에서 query를 받아 처리하는 형식으로 해야한다고 한다!

- 추가 ) 2014년 이후로 http get 메서드에서 body entity 사용이 가능은 하다고 함 / 다만 스프링에서는 지원을 안함 ㅠㅠ

---------------------

### 5. Docker & Jenkins

- 하나의 ec2 서버에 포트가 다른 여러 도커 컨테이너를 동작시킴으로써 환경이 다른 여러 서버(도커 이미지)를 한 서버에서 돌릴 수 있음

- 여기서 이미지는 하나의 서버 캡처본

- 컨테이너에 올려 동작시키는 것은 하나의 서버를 동작시키는 것

- 도커 컴포즈 => 디비, 백, 프론트 이미지를 빌드, 실행 테스트 하는 동작을 한번에 할 수 있게 도와줌

- 젠킨스로 파이프라인을 구성해 우리 프로젝트 깃랩과 서버를 연결하고, 머지 리퀘스트, 푸쉬 발생 시 도커 컴포즈를 실행시킴으로써 프론트, 백 도커 이미지를 빌드하고, 도커 허브에 푸쉬하고, 기존 이미지 및 컨테이너를 삭제하고, 다시 최신 이미지를 불러와 배포하는 로직을 자동화

--------------------

### 6. Input event

- `focus` 
  
  - 요소가 포커스가 되고 커서가 발생하여 입력이 가능해졌을 때 발생하는 이벤트
  
  - 이후 진행되는 인풋 관련 이벤트들이 발생하고 감지될 수 있는 시작점이 됨

- `blur` : 요소의 포커스가 해제되었을 때 발생하는 이벤트

- `change` : focus가 발생하기 전의 원래 입력값과 비교하여 변화가 일어났을 경우 blur 이벤트 이후에 발생하는 이벤트

- `input`
  
  - value 속성의 값이 바뀔 때마다 발생하는 이벤트
  
  - 일반적으로 keyPress 직후에 value 속성이 바뀌면서 input 이벤트가 발생 
  
  - input 이벤트 객체의 data 프로퍼티는 value 속성에 가장 최근 추가된 한 글자를 가짐 (영어의 경우 알파벳 한 글자, 한국어의 경우 초성/중성/종성으로 이루어진 한 글자)

- `keyDown` 
  
  - 키가 눌렸을 때 발생
  
  - input 이벤트 전에 발생

- `keyPress` 
  
  - 키가 눌렸을 때 발생하며, keyDown 이벤트 이후에 발생
  
  -  **한글 입력이나 기능키 입력시에는 발생하지 않음**
  
  -  [MDN에서 찾아보면 deprecated 되었다고 나오니](https://developer.mozilla.org/en-US/docs/Web/API/Document/keypress_event), input 이벤트 전에 입력을 제어하고 싶다면 keyDown 이벤트를 사용하는게 바람직해 보임

- `keyUp` 
  
  - input 이벤트 발생 후 value가 업데이트 된 이후에 키보드에서 손을 떼면 발생하는 이벤트
  
  - 키를 꾹 눌러서 입력을 반복하거나 할때는 발생하지 않음

- `paste` : 붙여넣기 감지
  
  ----------------------

- 이벤트 발생 순서 
  
  - `focus => keyDown => (keyPress) => input => keyUp => blur => change`
  
  - `keyDown(ctrl+v를 사용해서 붙여넣기 했을때만 발생) => paste => input => keyUp(ctrl+v를 사용해서 붙여넣기 했을때만 발생)`
