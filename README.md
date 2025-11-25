# Emotiverse

Emotiverse is an experimental emotional-intelligence companion that pairs every user with an evolving AI Mood Twin. This branch focuses on the first-touch experience (onboarding) and the main dashboard that anchors the AI twin interactions.

## What’s implemented

- **Immersive onboarding (`activity_main.xml`)**  
  A Material-themed layout that spotlights three custom mood illustrations, short value bullets, and CTAs for skipping or starting the journey. The screen uses a `ViewFlipper` so the demo visuals cycle automatically.

- **Deeply themed dashboard (`main_dashboard.xml`)**  
  The app lands on a scrollable dashboard that showcases the twin hero card, resonance meter, mood chips, stat tiles, emotion timeline, and curated rituals. Colors follow the warm palette requested by design.

## Why the extra drawables exist

File | Reason | How it’s used
---- | ------ | -------------
`drawable/ic_onboard_warm.xml` | Vector recreation of the yellow SVG mood card. | Displayed as the first illustration within the onboarding `ViewFlipper`.
`drawable/ic_onboard_calm.xml` | Vector recreation of the teal SVG mood card. | Second illustration in the onboarding carousel.
`drawable/ic_onboard_blush.xml` | Vector recreation of the coral SVG mood card with extra facial lines. | Third illustration in the onboarding carousel.
`drawable/dot_indicator_active.xml` & `drawable/dot_indicator_inactive.xml` | Simple oval shapes that mirror pagination indicators. | Rendered in `activity_main.xml` to show which onboarding slide is active.
`drawable/shape_circle_soft.xml`, `drawable/progress_timeline.xml`, `drawable/bottom_nav_background.xml`, `drawable/ic_bolt.xml` | Styling primitives introduced for the dashboard hero, progress bars, bottom navigation, and quick-action icon. | Referenced across `main_dashboard.xml` to keep UI consistent and modern.

All of these XML drawables are lightweight vector/shape resources. Using them avoids bundling bitmap assets, keeps APK size small, and allows colors to be tweaked directly in XML without regenerating artwork.

## Next steps

1. Hook the onboarding actions (`Skip`, `Get started`) to navigation logic.
2. Feed real mood data into the dashboard sections.
3. Consider transitions between onboarding slides (ViewPager2 + dots) if swipe gestures are desired.
