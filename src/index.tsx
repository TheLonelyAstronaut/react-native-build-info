import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-build-info' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const BuildInfo = NativeModules.BuildInfo
  ? NativeModules.BuildInfo
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export const getBuildTime = async (): Promise<Date> => {
  const time = await BuildInfo.getBuildTime();

  return new Date(Platform.OS === 'android' ? Number.parseInt(time) : time);
}
