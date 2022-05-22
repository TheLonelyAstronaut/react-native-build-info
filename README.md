# react-native-build-info

RN build info

## Installation

```sh
npm install react-native-native-build-info
```

## Usage

```js
import { getBuildTime } from "react-native-native-build-info";

// ...

const result = await getBuildTime();
```

## Setup

### Android

add this line to app/android/build.gradle

```
android {
  defaultConfig {
    ...
    buildConfigField "long", "TIMESTAMP", System.currentTimeMillis() + "L"
  }
}
```

### iOS

add Run Script phase to the very bottom of Build Phases, add script below, clean & rebuild

```
infoplist="$BUILT_PRODUCTS_DIR/$INFOPLIST_PATH"
builddate=`date`
if [[ -n "$builddate" ]]; then
/usr/libexec/PlistBuddy -c "Add :CFBuildDate $builddate" ${infoplist}
/usr/libexec/PlistBuddy -c "Set :CFBuildDate $builddate" ${infoplist}
fi
```

## License

MIT
