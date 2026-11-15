Tenant Management System
An Android app for landlords to record tenants, see total rent, and call tenants.

Download
Latest APK: see Releases on the right of this page.

Features
Register and log in
Dashboard with number of tenants and total rent
Add tenants and view all tenants (saved with Room)
Call a tenant, options menu and navigation drawer

Architecture
ui/ Activities, Fragments and TenantViewModel (UI layer)
data/ Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)
Flow: Screens → TenantViewModel (LiveData) → TenantRepository → Room

Team
| Stage  Member Admission No. Pull request 
| 1 Lead | Yetendo Gabriella | 192466 | https://github.com/gyetendo/TenantmanagementSystem/compare/main
| 2 ViewModel | Trisha Wakaba | 176173 | feature/viewmodel https://github.com/gyetendo/TenantmanagementSystem/pull/1#issue-6246067233 
| 3 Room | Gianna Mutheu | 189610 | |https://github.com/gyetendo/TenantmanagementSystem/pull/2#issue-6273304142
| 4 Screens | Shirlynn Muthomi| 190228 | https://github.com/gyetendo/TenantmanagementSystem/pull/3#issue-6340722646
| 5 Data integration | Ssennoga Tendo Lynette | 191338 | https://github.com/gyetendo/TenantmanagementSystem/pull/5#issue-6402035811 
| 6 Release | Yetendo Gabriella| 192466 | https://github.com/gyetendo/TenantmanagementSystem/compare/main 