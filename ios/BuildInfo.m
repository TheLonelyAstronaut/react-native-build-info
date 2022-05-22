#import "BuildInfo.h"

@implementation BuildInfo

RCT_EXPORT_MODULE()

// Example method
// See // https://reactnative.dev/docs/native-modules-ios
RCT_REMAP_METHOD(getBuildTime,
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)
{
    resolve([[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBuildDate"]);
}

@end
