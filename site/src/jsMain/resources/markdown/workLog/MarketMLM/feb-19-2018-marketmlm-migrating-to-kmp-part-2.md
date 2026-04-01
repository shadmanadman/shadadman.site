## feb-19-2018-marketmlm-migrating-to-kmp-part-2

As we figure out what deps need to be refactored in order to migrate to KMP. we faced other problems. this issue was kind of new for us, but nothing that we couldn't handel.
in this challenge we had a couple of impl that was not currently supported in KMP. I can mention:
1. permission handling
2. selecting from gallery
3. Capturing from Camera
4. handling webview content
5. playing product demo video & voices
6. showing notifications


At this time there was not any library in KMP that could handle above cases. now thanks to a unique ability in kmp called platform specific implementation we handled all above case using expect/actual mechanism. this mechanism was a kind of dependency injection that was handled by kmp platform itself. here is how it works:
1. we write our api in commonMain with `expect` syntaxt
2. then we implement that api in each platfrom with `actual` syntax

implementing each feature was a little time consuming but the result was amazing becuese the impl was native for each platform, the ux got a huge thumsup.