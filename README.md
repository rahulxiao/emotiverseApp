# Emotiverse

Emotiverse is an experimental emotional-intelligence companion that pairs every user with an evolving AI Mood Twin. This branch focuses on the first-touch experience (onboarding) and the main dashboard that anchors the AI twin interactions.

## What’s implemented

- **Immersive onboarding (`activity_main.xml`)**  
  Full-bleed SVG moods rotate inside a `ViewFlipper` while a minimal copy stack floats above the imagery. Skip / Get Started actions transition straight into the dashboard.

- **Deeply themed dashboard (`main_dashboard.xml`)**  
  The home tab showcases the AI twin hero, resonance meter, mood chips, stats, emotion timeline, and ritual list. A custom four-icon nav bar keeps the “Home” state highlighted while AI/Calendar/Settings sit idle.

## Why the extra drawables exist

File | Reason | How it’s used
---- | ------ | -------------
`drawable/ic_onboard_warm.xml` | Vector recreation of the yellow SVG mood card. | Displayed as the first illustration within the onboarding `ViewFlipper`.
`drawable/ic_onboard_calm.xml` | Vector recreation of the teal SVG mood card. | Second illustration in the onboarding carousel.
`drawable/ic_onboard_blush.xml` | Vector recreation of the coral SVG mood card with extra facial lines. | Third illustration in the onboarding carousel.
`drawable/dot_indicator_active.xml` & `drawable/dot_indicator_inactive.xml` | Simple oval shapes that mirror pagination indicators. | Rendered in `activity_main.xml` to show which onboarding slide is active.
`drawable/shape_circle_soft.xml`, `drawable/progress_timeline.xml`, `drawable/bottom_nav_background.xml`, `drawable/ic_bolt.xml` | Styling primitives introduced for the dashboard hero, progress bars, bottom navigation, and quick-action icon. | Referenced across `main_dashboard.xml` to keep UI consistent and modern.
`drawable/ic_nav_home.xml`, `drawable/ic_nav_ai.xml`, `drawable/ic_nav_calendar.xml`, `drawable/ic_nav_settings.xml`, `drawable/nav_item_shape.xml` | Iconography and shapes for the bottom navigation bar. | Used inside the new FrameLayout-based nav to keep icons centered with active/inactive tinting.

All of these XML drawables are lightweight vector/shape resources. Using them avoids bundling bitmap assets, keeps APK size small, and allows colors to be tweaked directly in XML without regenerating artwork.

## Next steps

1. Hook the onboarding actions (`Skip`, `Get started`) to navigation logic. ✅ (now launches `MainDashboardActivity`)
2. Feed real mood data into the dashboard sections.
3. Wire nav icon taps to actual destinations and add motion/selection states.
4. Consider transitions between onboarding slides (ViewPager2 + dots) if swipe gestures are desired.
